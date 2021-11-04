Explicación del TP3
Arquitectura 

El sistema será una aplicación Cliente-Servidor. Tendrá 2 clientes que consuman sus servicios. Por un lado, una aplicación desarrollada para celulares con Sistema Operativo Android, y por otro la aplicación de punto de venta que consulte por una Orden. El servidor será una aplicación de tipo REST API desarrollada con Spring Boot montada sobre un servidor Apache Tomcat. 
¿Qué es lo que hace Spring Boot?
Arma la arquitectura del proyecto de tal manera que no es necesario que tengamos que desarrollar y armar un servidor, ya que el mismo software lo crea por sí solo. Por ende, cada proyecto va a tener un servidor. 
Contamos con un API Gateway que tiene controladores, servicios, repositorio. Este último llama a un módulo y este se encarga de guardar la información.  Y tenemos un framework para hacer la persistencia. El Sistema utilizará base de datos H2 para la persistencia de información.
Utilizamos H2 porque es un software dinámico y se crea en el momento en el que levantamos la aplicación. No es necesario que tengamos instalado algo aparte. 
Swagger

Swagger es una herramienta que, los endpoint que nosotros tenemos en los controladores (para crear una orden, un usuario y un producto) nos lo muestra con una documentación simple. 
Utilizamos este tipo de herramienta para que el frontend se integre.

README
En este repositorio se encuentra la documentación de la etapa final del trabajo práctico del grupo 3. El cual tiene cómo proyecto la aplicación “Escanea Tus Productos”.
Nuestra aplicación tiene como fin que el cliente escanee sus propios productos a medida que realiza la compra, el cliente creará una orden de compra, el cual contendrá un listado de los distintos productos que han sido escaneados. Al cerrar dicha orden, se generaría un código QR que mostraría el detalle de la compra, y que debe ser escaneado por el cajero.
https://drive.google.com/file/d/1-eznWEZxRHfv7B_oC2J5rp5U8yQcMFb_/view?usp=sharing

Para esta última etapa nos enfocamos en realizar la implementación de la arquitectura para la funcionalidad principal de nuestro proyecto:
Crear un usuario.
Crear una orden de compra.
Agregar productos a dicha orden.
Generar el QR con el archivo CSV.
Al abrir el proyecto podemos ver dos módulos:

Es el módulo que contiene las entradas, que es lo que tengo que llamar para crear las distintas cosas previamente mencionadas.

Y un framework que se encarga de la parte de persistencia, este módulo se va a encargar de toda la parte del guardado de nuestra información.


