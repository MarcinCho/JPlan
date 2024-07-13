export default class TimeCardRequest {
    username: string;
    comment: string;
    active: boolean;
    edited: boolean;
    startTime: string;
    endTime: string;
    
    constructor(username: string, comment: string, active:boolean, edited: boolean, startTime: string, endTime: string){
        this.username = username;
        this.comment = comment;
        this.active = active;
        this.edited = edited;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}