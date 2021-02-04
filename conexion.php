<?php
$connect= mysqli_connect("127.0.0.1", "root", "", "jsonproyect");

//printf("ok");
/* verificar la conexión */

if (mysqli_connect_errno()) {
    printf("Falló la conexión: %s\n", mysqli_connect_error());
    exit();
}


$caracterespecial = "-_-";
?>