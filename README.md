# Escanea Tus Productos

En este repositorio se encuentra la documentación de la etapa final del trabajo práctico del grupo 3. El cual tiene cómo proyecto la aplicación “Escanea Tus Productos”.
Nuestra aplicación tiene como fin que el cliente escanee sus propios productos a medida que realiza la compra, el cliente creará una orden de compra, el cual contendrá un listado de los distintos productos que han sido escaneados. Al cerrar dicha orden, se generaría un código QR que mostraría el detalle de la compra, y que debe ser escaneado por el cajero.

https://drive.google.com/file/d/1-eznWEZxRHfv7B_oC2J5rp5U8yQcMFb_/view?usp=sharing

![gif](https://64.media.tumblr.com/a49d31b996409669b28745d2bd93e9ce/affa10ed2b220eaa-d8/s540x810/0435e47cb57b0aecab1553f55ee066185889b996.gifv)


Para esta última etapa nos enfocamos en realizar la implementación de la arquitectura para la funcionalidad principal de nuestro proyecto:
  + Crear un usuario.
  + Crear una orden de compra.
  + Agregar productos a dicha orden.
  + Generar el QR con el archivo CSV.

Al abrir el proyecto podemos ver dos módulos:

Es el módulo que contiene las entradas, me va a indicar qué es lo que tengo que llamar para crear los distintas servicios previamente mencionados.

![api-gw](https://64.media.tumblr.com/142317600323c84b8c1d3bf6fd45e508/09b103dd3a303e2a-6c/s400x600/ccd0b88442a5832590a69c311b80ffc4758cdc82.png)

Y un framework que se encarga de la parte de persistencia, este módulo se va a encargar de toda la parte del guardado de nuestra información.

![fwk](https://64.media.tumblr.com/1bf02339becaf0f38c5214d41392dfa2/09b103dd3a303e2a-40/s400x600/28bd75d2e82b91c01daa1a8a4c907aa82fd3b634.png)

El sistema será una aplicación ___Cliente-Servidor___. Tendrá 2 clientes que consuman sus servicios. Por un lado, una aplicación desarrollada para celulares con ___Sistema Operativo Android_, y por otro la aplicación de punto de venta que consulte por una Orden. El servidor será una aplicación de tipo ___REST API___ desarrollada con ___Spring Boot___ montada sobre un servidor ___Apache Tomcat___. 

¿Qué es lo que hace ___Spring Boot___?  
Arma la arquitectura del proyecto de tal manera que no es necesario que tengamos que desarrollar y armar un servidor, ya que el mismo software lo crea por sí solo. Por ende, cada proyecto va a tener un servidor. 
Contamos con un ___API Gateway___ que tiene controladores, servicios, repositorio. Este último llama a un módulo y este se encarga de guardar la información. Contamos con un framework para hacer la persistencia. El Sistema utilizará ___base de datos H2___ para la persistencia de información.
Utilizamos H2 porque es un software dinámico y se crea en el momento en el que levantamos la aplicación. No es necesario que tengamos instalado algo aparte. 

![arquitectura](https://64.media.tumblr.com/92f94ab9152ff9f608e0f102dab1c2b5/09b103dd3a303e2a-28/s1280x1920/9bbf30ed6ebb0eaa64c33e0a87efca15031d0aac.png)

También utilizamos la herramienta ___Swagger___. La cual nos lo muestra, con una documentación simple, los endpoint que nosotros tenemos en los controladores (para crear una orden, un usuario y un producto).
Utilizamos este tipo de herramienta para que el frontend se integre.

![swagger](https://64.media.tumblr.com/515c3846f015f09c9b472fc473b91226/fa74c26f155bbc73-42/s1280x1920/08cf0c05ff06f59859bf4f507b20e69cd04b87f0.jpg)

