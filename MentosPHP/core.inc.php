<?php

function dbConnection() {
    $host = "localhost";
    $user = "root";
    $pass = "";
    $con = mysql_connect($host, $user, $pass) or die("Error 1");
}

function checkUser($uId) {

    dbConnection();

    $dbName = "mentos";

    mysql_select_db($dbName) or die("Error 2");

    $sql = "SELECT id FROM entries WHERE id ='$uId'";
    $query = mysql_query($sql);
    $num_rows = mysql_num_rows($query);
    if ($num_rows > 0) {

        return true;
    }

    return false;
}

function inserting($uId, $deviceId, $command) {

    if (checkUser($uId)) {
        $dbName = "mentos";
        mysql_select_db($dbName) or die("Error 3");

        $sql = " UPDATE entries SET device_id= '$deviceId',status= '1' ,command= '$command'  WHERE id = '$uId'";

        $result = mysql_query($sql) or mysql_error();
        if ($result) {
            $report ['status'] =  1;
            $report ['msg'] = "Command Received";
            echo json_encode($report);
        } else {

            $report ['status'] = 0;
            $report ['msg'] = "Error  in receiving";
            echo json_encode($report);
        }
    } else {
        $report ['status'] = 0;
        $report ['msg'] = "Id Not Found";
        echo json_encode($report);
    }
}

?>