import * as AccUtils from "../accUtils";
import * as ko from "knockout";
import "ojs/ojknockout";
import "knockout";
import "ojs/ojknockout";
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


class accountFormViewModel {
    type : ko.Observable<string> | ko.Observable<any>;
    rate : ko.Observable<string> | ko.Observable<any>;
    balance : ko.Observable<string> | ko.Observable<any>;
    minBalance : ko.Observable<string> | ko.Observable<any>;
    overdraft : ko.Observable<string> | ko.Observable<any>;

constructor(){
    console.log("hello");
    this.type = ko.observable(null);
    this.rate = ko.observable(null);
    this.balance = ko.observable(null);
    this.minBalance= ko.observable(null);
    this.overdraft = ko.observable(null);   
    }

    public createaccountAction = async (event: Event) => {
        const row = {
            accountType:this.type(),
            accountRate: this.rate(),
            customer: {customer_id:4},
            accountBalance: this.balance(),
            accountMinimumBalance:this.minBalance(),
            overDraftAmount:this.overdraft()
          };
        var jsonData = JSON.stringify(row)
        console.log(jsonData);
        fetch("http://localhost:8080/customer/account",{
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

        });
      };
}   
export = accountFormViewModel;