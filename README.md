Se puede obtener el dashboard completo enviando solo la lista de enteros (altas y bajas) siguiente el orden:

0 - Alta oficial superior 1 - Baja oficial superior 2 - Alta oficial jefe 3 - Baja oficial jefe 4 - Alta oficial
subalterno 5 - Baja oficial subalterno 6 - Alta suboficial superior 7 - Baja suboficial superior 8 - Alta suboficial
subalterno 9 - Baja suboficial subalterno 10 - Alta agente civil 11 - Baja agente civil 12 - Alta soldado voluntario 13
- Baja soldado voluntario

En ese orden el metodo getCompleteDashboardPane del singleton CidesoDashboard, recibe la lista de enteros para generar
el dashboard por completo

O se puede optar por armar los graficos por separado, armando los nodos (graficos) usando los metodos:

* getEfectivosChart
* getDonutChart
* getGaugeChart
* getPieChart
* getSimpleStringChart

Y luego enviando una lista de esos nodos a:

getDashboardPane
