/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import 'ojs/ojknockout';
import * as ko from "knockout";
import * as Bootstrap from "ojs/ojbootstrap";
import * as AccUtils from "../accUtils";
import "ojs/ojinputtext";
import "ojs/ojformlayout";
import "ojs/ojinputtext";
import "oj-c/input-password";
import "ojs/ojlabel";
import "ojs/ojlabelvalue";
import "oj-c/button";
import { RESTDataProvider } from "ojs/ojrestdataprovider";
import { ojButtonEventMap } from '@oracle/oraclejet/ojbutton';




class DashboardViewModel {

  username: ko.Observable<string>;
  password: ko.Observable<string> | ko.Observable<any>;
  successMessage: ko.Observable<string>;
  errorMessage: ko.Observable<string>;


  
  constructor() {
    this.username = ko.observable("");
    this.password=ko.observable("");
    this.successMessage = ko.observable("");
    this.errorMessage = ko.observable("");

  }
    public loginAction = async (event: Event) => {
      // add to the observableArray
      console.log("enter")
      // Create row object based on form inputs
      const row = {
        customerLoginId: this.username(),
        customer_password: this.password()
      };

      var jsonData = JSON.stringify(row)
      console.log(jsonData);
      try {
        const response = await fetch("http://localhost:8080/customer/login", {
          method: 'POST',
          headers: new Headers({
            'Content-Type': 'application/json; charset=utf-8'
          }),
          body: jsonData
        });

        const data = await response.text();
        console.log(data);
        console.log(typeof(data));

        if (data.trim() === "login successfull") {
          this.successMessage("Login Successful");
          this.errorMessage(""); // Clear any previous error messages
          window.location.href="?ojr=homePage"
        } else {
          this.successMessage(""); // Clear any previous success messages
          this.errorMessage("Invalid username/password combination");
        }
      } catch (error) {
        console.error('Error during login:', error);
        this.successMessage(""); // Clear any previous success messages
        this.errorMessage("An error occurred. Please try again.");
      }

    };




  
}



export = DashboardViewModel;
