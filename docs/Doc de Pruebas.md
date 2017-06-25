<p>&nbsp;</p>
<p>&nbsp;</p>
<h1 style="text-align: center;">Documento de Pruebas</h1>
<h1 style="text-align: center;">&nbsp;</h1>
<h1 style="text-align: center;">Aplicaci&oacute;n DomoLinx</h1>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p><strong>Pruebas Unitarias</strong></p>
<p>Se prueba un &uacute;nico m&eacute;todo de una clase. El alcance es muy reducido y est&aacute; perfectamente acotado. Cualquier dependencia del m&oacute;dulo bajo prueba debe ser sustituida por un<a href="http://en.wikipedia.org/wiki/Mock_object"> mock</a>, o un stub.</p>
<p><strong>(M&eacute;todos de la clase DomoticController)</strong></p>
<p>@Test</p>
<p>testSanitizarTemperatura()</p>
<p>Se verifica que la temperatura ingresada en la caja de texto correspondiente este dentro del rango aceptable (mayor o igual a 0&deg;C, y menor o igual que 40&deg;C).</p>
<p>&nbsp;</p>
<p>@Test</p>
<p>&nbsp;&nbsp;&nbsp; testSetearTemperatura()</p>
<p>Este test verifica que el setter modifique la variable temperaturaDeseada del DomoticModel, siempre que esta est&eacute; dentro de los valores aceptados por el mismo.</p>
<p>&nbsp;</p>
<p>@Test</p>
<p>test_sanitizarHumedad ()</p>
<p>En esta prueba se verifica que el valor de humedad introducido en la caja de texto sea v&aacute;lido (debe pertenecer al intervalo [0,100]).</p>
<p>Se realizan varios test con valores dentro y fuera del intervalo para verificar este m&eacute;todo.</p>
<p>&nbsp;</p>
<p>@Test</p>
<p>testSetearHumedad()</p>
<p>Este test verifica que el setter cambie el valor de la variable humedadDeseada de la clase DomoticModel</p>
<p>&nbsp;</p>
<p><strong>(M&eacute;todos de la clase DomoticModel)</strong></p>
<p>@Test</p>
<p>testSetAc()</p>
<p>testSetHumidificador()</p>
<p>testSetEstufa()</p>
<p>&nbsp;</p>
<p>Estas pruebas unitarias verifican que los perif&eacute;ricos conectados al sistema reciban la correspondiente se&ntilde;al l&oacute;gica de encendido o apagado seg&uacute;n se requiera.</p>
<p>Nota:</p>
<p>Se realizaron varios test con diferentes valores para probar la cobertura de c&oacute;digo de los diferentes m&eacute;todos y para corroborar que las operaciones realizadas sean correctas. Se omiti&oacute; documentar los test unitarios correspondientes a setters y getters de esta clase.</p>
<p>&nbsp;</p>
<p><strong>Pruebas de Integraci&oacute;n</strong></p>
<p>Prueba la interacci&oacute;n entre dos o m&aacute;s elementos, que pueden ser clases, m&oacute;dulos, paquetes, subsistemas, etc&hellip; incluso la interacci&oacute;n del sistema con el hardware (o simulador).</p>
<p>&nbsp;</p>
<p><strong>&nbsp;</strong></p>
<p><br /> <strong>Pruebas de Sistema</strong></p>
<p>&nbsp;</p>
<p>En modo monitor, la vista muestra el estado actual de la temperatura y humedad que indican los sensores as&iacute; como tambi&eacute;n el estado en que se encuentran los dispositivos conectados: &ldquo;ON&rdquo; u &ldquo;OFF&rdquo;.</p>
<p>Prueba de generaci&oacute;n de un reporte en archivo .txt:</p>
<ul>
<li>DESCRIPCI&Oacute;N: Mediante la interfaz de usuario de la aplicaci&oacute;n se deber&aacute; hacer clic sobre el bot&oacute;n &ldquo;Generar txt&rdquo;.</li>
<li>PRECONDICIONES: Tener abierto la aplicaci&oacute;n y seleccionar la pesta&ntilde;a Monitor.</li>
<li>PROCEDIMIENTO: solo se debe hacer clic sobre el bot&oacute;n correspondiente (&ldquo;Generar txt&rdquo;).</li>
<li>RESULTADO ESPERADO: La aplicaci&oacute;n debe generar un archivo de texto que contenga un reporte del estado actual de los sensores, los valores seteados como deseados, y los perif&eacute;ricos.</li>
</ul>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>Prueba de seteo de temperatura deseada:</p>
<ul>
<li>DESCRIPCI&Oacute;N: Mediante la interfaz de usuario de la aplicaci&oacute;n se deber&aacute; aceptar un valor de temperatura deseada (siempre que est&eacute; en el intervalo permitido, 0&deg;C &lt; T &lt; 40&deg;C).</li>
<li>PRECONDICIONES: Tener abierto la aplicaci&oacute;n y seleccionar la pesta&ntilde;a Preset.</li>
<li>PROCEDIMIENTO: Se debe ingresar un valor num&eacute;rico en la caja de texto que corresponda al intervalo especificado (0&deg;C &lt; T &lt; 40&deg;C).</li>
<li>RESULTADO ESPERADO: La aplicaci&oacute;n debe seg&uacute;n la condici&oacute;n del sensor de temperatura hacer uso de los perif&eacute;ricos AC o Estufa mediante una se&ntilde;al l&oacute;gica hasta alcanzar el valor deseado de temperatura.
<ul>
<li>En caso de que el valor introducido por el usuario no pertenezca al intervalo admitido por el sistema, este ignorar&aacute; dicho valor.</li>
<li>La interfaz gr&aacute;fica (Vista) debe mostrar en tiempo real la actualizaci&oacute;n del valor de temperatura a medida que esta var&iacute;a.</li>
</ul>
</li>
</ul>
<p>&nbsp;</p>
<p>Prueba de seteo de humedad deseada:</p>
<ul>
<li>DESCRIPCI&Oacute;N: Mediante la interfaz de usuario de la aplicaci&oacute;n se deber&aacute; aceptar un valor de humedad deseada (siempre que est&eacute; en el intervalo permitido, 0% &lt; H &lt; 100%).</li>
<li>PRECONDICIONES: Tener abierto la aplicaci&oacute;n y seleccionar la pesta&ntilde;a Preset, ubicarse en la caja de texto correspondiente a Humedad Deseada.</li>
<li>PROCEDIMIENTO: Se debe ingresar un valor num&eacute;rico en la caja de texto que corresponda al intervalo especificado ( [0,100] ---------&gt; 0% &lt; H &lt; 100%).</li>
<li>RESULTADO ESPERADO: La aplicaci&oacute;n debe seg&uacute;n la condici&oacute;n del sensor de humedad hacer uso del perif&eacute;rico Humidificador mediante una se&ntilde;al l&oacute;gica hasta alcanzar el valor deseado de humedad.
<ul>
<li>Tanto en la pesta&ntilde;a Monitor como en la pesta&ntilde;a Preset, la interfaz gr&aacute;fica (Vista) debe mostrar en tiempo real el cambio del valor de la humedad.</li>
<li>En caso de que la humedad deseada sea m&aacute;s baja que la humedad le&iacute;da por el sensor, el sistema no har&aacute; nada (la humedad bajar&aacute; naturalmente).</li>
<li>En caso de que el valor introducido por el usuario no pertenezca al intervalo admitido por el sistema, este deber&aacute; ser ignorado.</li>
</ul>
</li>
</ul>
<p><strong>&nbsp;</strong></p>
<p><strong>Matriz de trazabilidad</strong></p>
<p><strong>&nbsp;</strong></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p><strong>&nbsp;</strong></p>
<p>&nbsp;</p>