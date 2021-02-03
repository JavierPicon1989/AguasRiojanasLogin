<?php

include 'conexion.php';
$usuario = filter_input(INPUT_POST,"usuario");
$password = filter_input(INPUT_POST, "password");

$query= "SELECT id, email, nombre, password FROM users WHERE nombre = '$usuario' and password= '$password'";
 $result= mysqli_query($connect, $query);
 
 $data =array();
 $i= 0;
 
 while ($row= mysqli_fetch_array($result)){
     $data[$i]= $row;
     $i++;
 }
 echo json_encode($data);
 
 

  
  
?>