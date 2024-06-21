import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnamneseComponent } from './components/anamnese/anamnese.component';
import { AlunoComponent } from './components/aluno/aluno.component';

const routes: Routes = [
  {path: '', component: AnamneseComponent},
  {path: 'aluno', component: AlunoComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
