REALIZANDO EL ENVIO DE MENSAJES DE CELULAR A CELULAR

Creamos la clase Globales, la cual contendra las siguientes variables, la variable "usuariosRed" es un arreglo de la clase RedSocial

![](.MENS_WTSPP_images/f56a5d6a.png)

Creamos el layout activity_lista_red.xml el cual esta asociado a la clase ActivityListaRed

![](.MENS_WTSPP_images/8af05b8e.png)

De igual forma creamos el layout item_simple_redsocial.xml el cual servirá para tener todos los datos de los usuarios que ingresen a la apliación, con ésta podremos ingresar foto, nombre del usuario, etc

![](.MENS_WTSPP_images/211233cb.png)

En este caso añadimos las divisiones de los usuarios, añadimos el ancho de éstas.

![](.MENS_WTSPP_images/14e194db.png)

En la clase ActivityListaRed lo enlazamos con el layout activity_lista_red.xml el cual será nuestro punto de entrada

![](.MENS_WTSPP_images/35aaf27c.png)

El método TareaLeerTodos se va a ejecutar y va a regresar el listado "usuariosred" que es el listado que se han registrado y que tienen su token.
1-.Primero se obtiene los usiarios de la REDSOCIAL a través de la tarea que se conecta al backend.
2-.