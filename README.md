Geektic
=======

Auteur : M�lanie ROSSET
Serveur utilis� : Tomcat
Base de donn�es : HSQLDB, nom  : Geektic
Page d'accueil : /Geektic/accueil

Remarques :

* Mon fichier build.gradle contient une d�pendance suppl�mentaire, vers joda-datetime :
compile 'joda-time:joda-time:2.2'

* Mes tests sont con�us pour fonctionner exclusivement avec les donn�es � ins�rer � l'aide du script data.sql. Merci de vider les tables et ex�cuter le script avant de lancer les tests.

* J'ai essay� de d�ployer mon application sur un cloud, mais j'ai �t� bloqu�e � l'IUT car les clouds demandent tous d'installer un outil ou un autre et nous n'avons pas les droits administrateur.