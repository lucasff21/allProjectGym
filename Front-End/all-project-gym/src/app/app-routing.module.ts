import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnamneseComponent } from './components/anamnese/anamnese.component';

const routes: Routes = [
  {path: '', component: AnamneseComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
