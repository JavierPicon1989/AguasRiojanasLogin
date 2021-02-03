<?php


        function mostrarPermisos($id_users){
            include 'conexion.php';
            $sqlSelect= "SELECT users.nombre, modulos.nombre FROM users INNER JOIN permisos ON permisos.id_users=users.id INNER JOIN modulos "
                    . "ON permisos.id_modulos=modulos.id WHERE id_users=$id_users";

            if(!$result = mysqli_query($connect, $sqlSelect)) {
                   die( "ERROR: " . mysqli_error($connect));
                }
                $data = array();
                $i=0;
                //Recorremos el arreglo
                while($row = mysqli_fetch_array($result))
                {
                    $data[$i] = $row;
                    $i++;
                }
                return $data;
        }
/*----------------------------------------------------------------*/
        function agregarPermiso($id_users,$id_modulos){
            include 'conexion.php';
            
            $sqlInsert= "INSERT INTO permisos VALUES('','$id_users','$id_modulos')";
            if($rs= mysqli_query($connect,$sqlInsert)){
                echo 'Permiso agregado';
              } 
            
        }
/*----------------------------------------------------------------*/       
        function editarPermiso($id_modulos, $id_permisos){
            include 'conexion.php';
            $sqlUpdate="UPDATE permisos SET id_modulos='$id_modulos' WHERE id=$id_permisos";
            if ($rs= mysqli_query($connect,$sqlUpdate)){
                echo 'Permiso editado';
            }
            
        }
/*-----------------------------------------------------------------*/
        function borrarPermiso($id_permisos){
            include 'conexion.php';
             $sqlDelete="DELETE FROM permisos WHERE id=$id_permisos";
             if ($rs= mysqli_query($connect,$sqlDelete)) {
                 echo 'Permiso borrado';
             }
        }
/*-----------------------------------------------------------------*/
        
        


