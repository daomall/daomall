<?php

$host = 'localhost';
$user = 'root';
$pwd = 'root';
$db = 'daomall';
$prefix = '';
$packageName = 'com.daosoft.daomall';
$packagePath = __DIR__ . '/src/main/java/com/daosoft/daomall/';
$entityPath = $packagePath . 'entity/';
$repositoryPath = $packagePath . 'repository/';

// init


// processor

$conn = mysqli_connect($host, $user, $pwd, $db) or die("连接错误: " . mysqli_connect_error());

mysqli_query($conn, 'SET NAMES utf8mb4');

$result = mysqli_query($conn, 'show tables');

while ($row = $result->fetch_assoc()) {
    $table = $row['Tables_in_' . $db];
    $name = str_replace($prefix, '', $table);

    $sql = "select * from information_schema.columns where table_schema ='" . $db . "' and table_name = '" . $table . "' ";
    $res = mysqli_query($conn, $sql);
    $fields = [];
    while ($r = $res->fetch_assoc()) {
        $fields[] = $r;
    }

    generateClass(parse_name($name, 1), $fields, $table);
}

mysqli_close($conn);

function generateClass($name, $fields, $table)
{
    global $packageName, $entityPath, $repositoryPath;

    $fieldAttr = generateField($fields);

    // generate entity
    $entity = 'package ' . $packageName . ".entity;\n\n";
    $entity .= 'import lombok.Data;' . "\n\n";
    $entity .= 'import javax.persistence.*;' . "\n\n";
    $entity .= '@Entity(name = "' . $table . '")' . "\n";
    $entity .= '@Data' . "\n";
    $entity .= 'public class ' . $name . " {\n\n";
    $entity .= $fieldAttr;
    $entity .= '}' . "\n";
    file_put_contents($entityPath . $name . '.java', $entity);

    // generate repository
    $repository = 'package ' . $packageName . ".repository;\n\n";
    $repository .= 'import ' . $packageName . '.entity.' . $name . ';' . "\n";
    $repository .= 'import org.springframework.data.jpa.repository.JpaRepository;' . "\n\n";
    $repository .= "public interface {$name}Repository extends JpaRepository<{$name}, Long> {\n";

    $repository .= '}' . "\n";
    file_put_contents($repositoryPath . $name . 'Repository.java', $repository);
}

/**
 * 生成实体对象属性
 * @param $fields
 * @return string
 */
function generateField($fields)
{
    $attr = '';
    foreach ($fields as $v) {
        if ($v['COLUMN_KEY'] == 'PRI') {
            $attr .= "    @Id\n";
            $attr .= "    @GeneratedValue(strategy = GenerationType.IDENTITY)\n";
            $attr .= '    @Column(columnDefinition = "INT(11) UNSIGNED")' . "\n";
        } else {
            $null = ($v['IS_NULLABLE'] == 'NO') ? 'nullable = false, ' : '';
            $comment = str_replace('"', ' ', $v['COLUMN_COMMENT']);
            $attr .= "    // {$comment}\n";
            $attr .= "    @Column({$null}columnDefinition = \"{$v['COLUMN_TYPE']} DEFAULT '{$v['COLUMN_DEFAULT']}'\")\n";
        }

        $type = getDbType($v['DATA_TYPE']);
        $field = parse_name($v['COLUMN_NAME'], 1, false);

        if ($field == 'default') {
            $field = 'isDefault';
        }

        $attr .= "    private {$type} {$field};\n\n";
    }

    return $attr;
}

/**
 * 根据mysql类型返回java类型
 * @param $type
 * @return string
 */
function getDbType($type)
{
    if (stripos($type, 'char') !== false || stripos($type, 'text') !== false) {
        return 'String';
    }

    if (stripos($type, 'int') !== false) {
        return 'Long';
    }

    if ($type == 'decimal' || $type == 'double') {
        return 'java.math.BigDecimal';
    }

    if ($type == 'date' || $type = 'time') {
        return 'java.util.Date';
    }

    die('unknown mysql field type: ' . $type);
}

/**
 * 字符串命名风格转换
 * type 0 将Java风格转换为C的风格 1 将C风格转换为Java的风格
 * @param string $name 字符串
 * @param int $type 转换类型
 * @param bool $ucfirst 首字母是否大写（驼峰规则）
 * @return string
 */
function parse_name($name, $type = 0, $ucfirst = true)
{
    if ($type) {
        $name = preg_replace_callback('/_([a-zA-Z])/', function ($match) {
            return strtoupper($match[1]);
        }, $name);

        return $ucfirst ? ucfirst($name) : lcfirst($name);
    }

    return strtolower(trim(preg_replace('/[A-Z]/', '_\\0', $name), '_'));
}
