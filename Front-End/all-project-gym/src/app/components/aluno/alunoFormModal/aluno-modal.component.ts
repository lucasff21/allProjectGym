import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { ExercicioService } from 'src/app/services/exercicio.service';
import { iAlunoModel } from '../iAlunoModel';

@Component({
  selector: 'app-aluno-modal',
  templateUrl: './aluno-modal.component.html',
  styleUrls: ['./aluno-modal.component.scss']

})
export class AlunoModalComponent implements OnInit {


  exercicioList: any[] = [];

  formAluno: FormGroup

  constructor(
    public dialogRef: MatDialogRef<AlunoModalComponent>,
    private formBuilder: FormBuilder,
    private httpClientExercicioService: ExercicioService,
    @Inject(MAT_DIALOG_DATA) public data: { aluno: iAlunoModel },
  ) {
    this.formAluno = this.formBuilder.group({
      id: [data.aluno?.id || null],
      nome: [data.aluno?.nome || '', [Validators.required]],
      idade: [data.aluno?.idade || '', [Validators.required]],
      exercicios: [data.aluno?.exercicios || [], Validators.required]
    })
  }

  ngOnInit(){
    this.findAllExercicios()
  }

  closeModal(): void {
    this.dialogRef.close(undefined);
  }

  save(){
    this.dialogRef.close(this.formAluno.value);
  }

  findAllExercicios(){
    this.httpClientExercicioService.getAllAnamnese().subscribe({
      next: (exercicios) => {
        this.exercicioList = exercicios
      }
    })
  }
}
