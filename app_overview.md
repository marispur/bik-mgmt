## Introduction ##

The **BIK designer** application is intended to assist in building Buvdarbu Izcenojumu Katalogs (BIK) by MV project, SIA (Latvia). Application allows user to maintain structured catalogue of construction estimations.

It is JAVA application built using MVC like architecure. Currently work on version 1.0 is in progress

## Features ##
Table bellow illustrates main features BIK designer application is going to provide.
| **Version** | **Component** | **Description** |
|:------------|:--------------|:----------------|
| 1.0         | UI            | Editing and seamless storage to database of BIK items: Section, subsection, work items, work component items (depreciation, labour, materails) |
| 1.0         | UI            | Select only one line at a time |
| 1.0         | UI            | Isertion and deletion of BIK items |
| 1.0         | UI            | Automatic update or depending values after edit |
| 1.0         | UI            | Show last 5 history events for selected BIK item |
| 1.0         | DATA          | Instant storage of changes to PostgreSQL server |
| 1.0         | SECURITY      | User accounting and logging of changes performed |
| 1.0         | SECURITY      | No user permissions to objects everyone has write permissions |
| 1.1         | GENERAL       | Export of current catalog version to XML  |



## Architectural details ##

The application uses PostgresSQL server as data storage and Java SWING for UI.