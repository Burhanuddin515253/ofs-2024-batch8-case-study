export class Employee{
    constructor(id,name,salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }

    display(){
        console.log(`id=${this.id}`);
    }
}