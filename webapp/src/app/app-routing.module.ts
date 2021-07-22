import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './login/login.component'
import {RegisterComponent} from './register/register.component';
import { MonitorBoardComponent } from './monitor-board/monitor-board.component';
import { TopmenuComponent } from './topmenu/topmenu.component';
import { AuthGuard } from './auth/auth.guard';
import { BgcomponentComponent} from './bgcomponent/bgcomponent.component';
import { RootdashboardComponent } from './rootdashboard/rootdashboard.component';
import { WastagedashboardComponent } from './wastagedashboard/wastagedashboard.component';
import { AnomalydashboardComponent } from './anomalydashboard/anomalydashboard.component';
import { SubsidiseddashboardComponent } from './subsidiseddashboard/subsidiseddashboard.component';

const routes: Routes = [

  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'interruption', component: MonitorBoardComponent},
  {path: '', component: BgcomponentComponent},
  {path: 'selectaction', component: RootdashboardComponent},
  { path: 'wastage', component: WastagedashboardComponent },
  {path: 'anomaly', component: AnomalydashboardComponent},
  { path: 'subsidised', component: SubsidiseddashboardComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
