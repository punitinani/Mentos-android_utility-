<?php

session_start();
$_SESSION['did']= json_decode($_GET['deviceid']);
$uId = json_decode($_GET['uId']);
$deviceId = json_decode($_GET['deviceid']);
$command = json_decode($_GET['command']);
@ require_once 'core.inc.php';
inserting($uId, $deviceId, $command);

?>
