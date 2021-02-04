<?php
include 'metodosPermisos.php';

$id_user = filter_input(INPUT_POST,"id_user");
//$id_modulo = filter_input(INPUT_POST,"id_modulo");

$permiso = mostrarPermisos($id_user);
echo json_encode($permiso);


