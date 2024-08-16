/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import ko = require("knockout");
import * as AccUtils from "../accUtils";
import "oj-c/input-text";
import "oj-c/input-number";
import "ojs/ojknockout";
import "oj-c/input-password";
import "oj-c/input-date-text";
class DashboardViewModel {
  value: ko.Observable<string> ; 
  firstname : ko.Observable<string> | ko.Observable<any>;
  salary: ko.Observable<number> | ko.Observable<any>;
  password: ko.Observable<string> | ko.Observable<any>;
  date: ko.Observable<Date> | ko.Observable<any>;
    constructor() {
      this.value = ko.observable("Green");
      this.firstname = ko.observable(null);
      this.salary=ko.observable(null);
      this.password=ko.observable(null);
      this.date=ko.observable(null);
    }
  
}

export = DashboardViewModel;