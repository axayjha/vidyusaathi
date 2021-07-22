import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GlobalService {

  provider: any;
  authorisationCode: string;
  showLogin = false;
  constructor() { }
  getProvider(): any {
    return this.provider;
  }
}
