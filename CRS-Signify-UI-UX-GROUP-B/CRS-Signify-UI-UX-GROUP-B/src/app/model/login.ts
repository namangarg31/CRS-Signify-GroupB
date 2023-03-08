export class Login {
    public id:number;
    public password:String;
    public role:String;
    constructor(id:number,password:String,role:String){
        this.id = id;
        this.password = password;
        this.role = role;
    }
}