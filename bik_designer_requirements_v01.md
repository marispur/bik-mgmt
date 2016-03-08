## Introduction ##

The aim of version 0.1 is to create functional Java SWING application which allows to design BIK construction estimation catalogue and uses PostgreSQL server as object storage.


## Details ##

The following BIK object types muct be visible in defined hiearachy:
  1. Section
  1. Subsection
  1. Work item
  1. Work item component (4 types: Labour, Materials, Depreciation and Depreciation %)
  1. Comment

_Section_ may contain _Subsections_, _Subsections_ - _Work items_ and _Work items_ consist of _Work item compnents_.
_Section_ and _Subsection_ objects may have 0 or several _Comment_ objects
Some _Work item components_ may use predefined prices.

## Functions ##

  * Adding and removal of BIK components from catalogue.
  * Automatic calculation of _work item_ values if _work item components_ are changed (added/deleted/updated/defined price applied).
  * Displays _defined prices_ table with read-only functionality when user requests.
  * Multi-user support
  * Immediate storage of changes to server (when user changes selection or focus)
  * Change history storage for every BIK item