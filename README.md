# Escanea Tus Productos



En este repositorio se encuentra la documentación del **TRABAJO PRÁCTICO Nº3**, el cual tiene como proyecto la aplicación “Escanea Tus Productos”.

Nuestra aplicación tiene como fin que el cliente escanee sus propios productos a medida que realiza la compra. Es decir, el cliente creará una orden de compra, el cual contendrá un listado de los distintos productos que han sido escaneados. Al cerrar dicha orden, se generaría un código QR que mostraría el detalle de la compra y que debe ser escaneado por el cajero.
 
## Funcionamiento

Para esta última etapa nos enfocamos en realizar la implementación de la arquitectura para la funcionalidad principal de nuestro proyecto:
  + Crear un usuario.
  + Crear una orden de compra.
  + Agregar productos a dicha orden.
  + Generar el QR con el archivo CSV.

Al abrir el proyecto podemos ver dos módulos:

1. Es el módulo que contiene las entradas, me va a indicar qué es lo que tengo que llamar para crear los distintas servicios previamente mencionados.

<div align="center">

![api-gw](https://64.media.tumblr.com/142317600323c84b8c1d3bf6fd45e508/09b103dd3a303e2a-6c/s400x600/ccd0b88442a5832590a69c311b80ffc4758cdc82.png)

</div>  
  
2. Y un framework que se encarga de la parte de persistencia, este módulo se va a encargar de toda la parte del guardado de nuestra información.

<div align="center">  
  
![fwk](https://64.media.tumblr.com/1bf02339becaf0f38c5214d41392dfa2/09b103dd3a303e2a-40/s400x600/28bd75d2e82b91c01daa1a8a4c907aa82fd3b634.png)

</div>  
  
El sistema será una aplicación ___Cliente-Servidor___. Tendrá 2 clientes que consuman sus servicios: 
- Por un lado, una aplicación desarrollada para celulares con ___Sistema Operativo Android___, y 
- Por otro, la aplicación de punto de venta que consulte por una orden. 

El servidor será una aplicación de tipo ___REST API___ desarrollada con ___Spring Boot___ montada sobre un servidor ___Apache Tomcat___. 

**Spring Boot** arma la arquitectura del proyecto de tal manera que no es necesario que tengamos que desarrollar y armar un servidor, ya que el mismo software lo crea por sí solo. Por ende, cada proyecto va a tener un servidor. 

Además, contamos con un ___API Gateway___ que tiene controladores, servicios y repositorio. Este último llama a un módulo, el cual se encarga de guardar la información.

El Sistema utilizará ___Base de Datos H2___ para la persistencia de información. Utilizamos ___H2___ porque es un software dinámico y se crea en el momento en el que levantamos la aplicación. No es necesario que tengamos instalado algo aparte. 

<div align="center">

![arquitectura](https://64.media.tumblr.com/86c5b85a4fc1a4d67982ce068cdcc02f/524ab27344ac6d6b-ac/s2048x3072/96aeee5b139f87cd60cbfdfdf9eda2f244655a17.png)

</div>  
  
También utilizamos la herramienta ___Swagger___, la cual nos muestra, con una documentación simple, los endpoint que nosotros tenemos en los controladores (para crear una orden, un usuario y un producto). Utilizamos este tipo de herramienta para que el frontend se integre.

<div align="center">  
  
![swagger](https://64.media.tumblr.com/9bb4602d4fab79f17f8b22a4a3dd4433/c99d738892b8579d-ad/s540x810/f7a112faf2773174e5f954ad52902154fbc1f868.png)

</div>  
  
## Interfaz
Para realizar el prototipo de la interfaz utilizamos la aplicación ___Figma___, ya que sentimos que ofrece todas las herramientas necesarias para diseñar un proyecto. Además, nos permitió trabajar en simultáneo de manera online a tiempo real.

<div align="center">

![gif](https://64.media.tumblr.com/390d6141cd7323c0ead1e14a6df621ec/544865017f376f61-d8/s250x400/f160233304741b1e60e58453ff9b1594fad31790.gifv)

*El .gif sólo se muestra como guía, las interfaces reales e interactivas se encuentran en el link de abajo
 
 https://www.figma.com/file/Txnyny8Ag66pLSfLFnnVYL/Escanea-Tus-Productos?node-id=74%3A412
 
</div> 


