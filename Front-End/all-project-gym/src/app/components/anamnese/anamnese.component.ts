import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AnamneseService } from 'src/app/services/anamnese.service';

@Component({
  selector: 'app-anamnese',
  templateUrl: './anamnese.component.html',
  styleUrls: ['./anamnese.component.scss']
})
export class AnamneseComponent implements OnInit {

  listaAnamnese: any[] = []
  formAnamnese!: FormGroup;
  id: any

  constructor(
    private httpClientAnamneseService: AnamneseService,
    private formBuilder: FormBuilder,
  ){
    this.formAnamnese = this.formBuilder.group({
      data: ['', [Validators.required]],
      peso: ['', [Validators.required]],
      altura: ['', [Validators.required]],
      circunferencia_cintura: ['', [Validators.required]],
      circunferencia_quadril: ['', [Validators.required]],
      percentual_gordura: ['', [Validators.required]],
      massa_magra: ['', [Validators.required]],
      massa_gorda: ['', [Validators.required]],
      massa_muscular: ['', [Validators.required]],
      imc: ['', [Validators.required]]
    })

  }

  ngOnInit(): void {
    this.getAll()
  }


  getAll(){
    this.httpClientAnamneseService.getAllAnamnese().subscribe({
      next: (dados) => {
        this.listaAnamnese = dados
      }
    })
  }

  onSubmit(){
    if(!this.id){
      this.saveAnamnese();
    }
  }

  saveAnamnese(){
    this.httpClientAnamneseService.saveAnamnese(this.formAnamnese.value)
    .subscribe({
      next: (dados) => {
        window.location.reload();
      }
    })
  }
}
