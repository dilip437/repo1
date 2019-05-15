import { Injectable } from '@angular/core';
@Injectable()
export class SiblingSharedService {
    private _message:string=''
   constructor() {}
   set message(msg) {
    this._message=msg;
   }
   get message() {
       return this._message;
   }
}