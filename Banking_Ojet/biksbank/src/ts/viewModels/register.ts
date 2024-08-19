

import * as AccUtils from "../accUtils";
import * as ko from "knockout";
import * as Bootstrap from "ojs/ojbootstrap";
import "oj-c/input-number";
import "oj-c/input-text";
import "ojs/ojknockout";
import "ojs/ojknockout";
import Message = require("ojs/ojmessaging");
import 'oj-c/input-password';
import "ojs/ojlabel";
import * as ResponsiveUtils from 'ojs/ojresponsiveutils';
import { IntlConverterUtils } from 'ojs/ojconverterutils-i18n';
import { ojDatePicker } from 'ojs/ojdatetimepicker';
import 'ojs/ojknockout';
import 'ojs/ojdatetimepicker';
import 'ojs/ojlabel';
import "oj-c/form-layout";
import "knockout";
import "ojs/ojknockout";
import "oj-c/button";

class RegisterViewModel {
  custname: ko.Observable<string> | ko.Observable<any>;
  username: ko.Observable<string> | ko.Observable<any>;
  password: ko.Observable<string> | ko.Observable<any>;
  email: ko.Observable<string> | ko.Observable<any>;
  address: ko.Observable<string> | ko.Observable<any>;
  phone: ko.Observable<string> | ko.Observable<any>;
  state: ko.Observable<string> | ko.Observable<any>;
  country: ko.Observable<string> | ko.Observable<any>;
  successMessage: ko.Observable<string>;
  errorMessage: ko.Observable<string>;


  constructor() {

    this.custname = ko.observable(null);
    this.username = ko.observable(null);
    this.password = ko.observable(null);
    this.email = ko.observable(null);
    this.address = ko.observable(null);
    this.phone = ko.observable(null);
    this.state = ko.observable(null);
    this.country = ko.observable(null);
    this.successMessage = ko.observable("");
    this.errorMessage = ko.observable("");
  }

  public registerAction = async (event: Event) => {
    const row = {
        customer_name:this.custname(),
        customerLoginId: this.username(),
        customer_password: this.password(),
        customer_email:this.email(),
        customer_address:this.address(),
        customer_phone:this.phone(),
        customer_state:this.state(),
        customer_country:this.country()

      };
    var jsonData = JSON.stringify(row)
    console.log(jsonData);
    fetch("http://localhost:8080/customer/register",{
        method : 'POST',

        headers: new Headers(
            {'Content-Type': 'application/json; charset=utf-8'}
        ),
        body: jsonData
    })
    .then(response =>
        response.text())
    .then(data =>{
        console.log("hihello");
        console.log(data);
        console.log(typeof(data));
        if(data.trim() === "success"){
            //setFormMessage(createAccountForm, "success", "Register Successfull");
            this.successMessage("Register Successful");
            this.errorMessage(""); // Clear any previous error messages
            window.location.href="?ojr=dashboard"
            
        }else{
            this.successMessage("Register failed");
            this.errorMessage(""); // Clear any previous error messages
            
        }
    });
  }
}

export = RegisterViewModel;