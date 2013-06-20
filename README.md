Geektic
=======

Auteur : Mélanie ROSSET
Serveur utilisé : Tomcat
Base de données : HSQLDB, nom  : Geektic
Page d'accueil : /Geektic/accueil

Remarques :

* Mon fichier build.gradle contient une dépendance supplémentaire, vers joda-datetime :
compile 'joda-time:joda-time:2.2'

* Mes tests sont conçus pour fonctionner exclusivement avec les données à insérer à l'aide du script data.sql. Merci de vider les tables et exécuter le script avant de lancer les tests.

* J'ai essayé de déployer mon application sur un cloud, mais j'ai été bloquée à l'IUT car les clouds demandent tous d'installer un outil ou un autre et nous n'avons pas les droits administrateur.