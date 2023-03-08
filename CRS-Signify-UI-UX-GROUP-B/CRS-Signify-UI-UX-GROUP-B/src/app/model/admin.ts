export class Admin {
    public id:number;
    public password:String;
    public role:String;
    public name: String;
    public part: String;
    public depart: String;
    public des: String;
    public profid: number;
    public coursename: String;
    public studid: number;
    public doj: String;
    constructor(id:number,password:String,role:String, name: String, part: String, depart:String,des:String,profid:number,coursename:String,studid:number, doj:String){
        this.id = id;
        this.password = password;
        this.role = role;
        this.name = name;
        this.part = part;
        this.depart = depart;
        this.des = des;
        this.profid = profid;
        this.coursename = coursename;
        this.studid = studid;
        this.doj=doj;
    }
}