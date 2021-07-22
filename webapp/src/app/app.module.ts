import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatIconModule } from '@angular/material/icon';
import { GoogleChartsModule } from 'angular-google-charts';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatBadgeModule } from '@angular/material/badge';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatDatepickerModule } from '@angular/material/datepicker';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TopmenuComponent } from './topmenu/topmenu.component';
import { LoginComponent } from './login/login.component';
import { MatInputModule, MatButtonModule, MatSelectModule, MatRadioModule, MatCardModule, MatRadioGroup, MatNativeDateModule } from '@angular/material';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { RegisterComponent } from './register/register.component';
import { MonitorBoardComponent } from './monitor-board/monitor-board.component';
import { GraphviewComponent } from './graphview/graphview.component';
import { InfoviewComponent } from './infoview/infoview.component';
import { LivefeedbackComponent } from './livefeedback/livefeedback.component';
import { AreadataComponent } from './areadata/areadata.component';
import { BgcomponentComponent } from './bgcomponent/bgcomponent.component';
import { AuthGuard } from './auth/auth.guard';
import { UserService } from './user.service';
import { CustomermonitorComponent } from './customermonitor/customermonitor.component';
import { GlobalService } from './service/global.service';
import { HttpServiceService } from './service/http-service.service';
import { RootdashboardComponent } from './rootdashboard/rootdashboard.component';
import { WastagedashboardComponent } from './wastagedashboard/wastagedashboard.component';
import { AnomalydashboardComponent } from './anomalydashboard/anomalydashboard.component';
import { SubsidiseddashboardComponent } from './subsidiseddashboard/subsidiseddashboard.component';



@NgModule({
  declarations: [
    AppComponent,
    TopmenuComponent,
    LoginComponent,
    RegisterComponent,
    MonitorBoardComponent,
    GraphviewComponent,
    InfoviewComponent,
    LivefeedbackComponent,
    AreadataComponent,
    BgcomponentComponent,
    CustomermonitorComponent,
    RootdashboardComponent,
    WastagedashboardComponent,
    AnomalydashboardComponent,
    SubsidiseddashboardComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatRadioModule,
    MatCardModule,
    ReactiveFormsModule,
    MatGridListModule,
    MatIconModule,
    ReactiveFormsModule,
    FormsModule,
    GoogleChartsModule.forRoot(),
    MatButtonToggleModule,
    MatBadgeModule,
    MatSidenavModule,
    MatListModule,
    HttpClientModule,
    MatProgressBarModule,
    MatDatepickerModule,
    MatNativeDateModule,
  ],
  providers: [AuthGuard, UserService, GlobalService, HttpServiceService],
  bootstrap: [AppComponent]
})
export class AppModule {}
