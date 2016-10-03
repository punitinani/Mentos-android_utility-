<?php

//change f to the get to post 
$uId = json_decode($_GET['id']);
@ require_once 'core.inc.php';
if (checkUser($uId)) {
    $report ['status'] =  1;
    $report ['msg'] = "Id found ";
       echo json_encode($report);
} else {
    $report ['status'] =  0;
    $report ['msg'] = "Id Not Found ";
    echo json_encode($report);
   }
?>