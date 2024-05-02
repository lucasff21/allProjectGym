import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AnamneseService } from 'src/app/services/anamnese.service';
import { iAnamneseModel } from './iAnamneseModel';
import { MatSnackBar } from '@angular/material/snack-bar';

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
    private _snackBar: MatSnackBar
  ) {
    this.formAnamnese = this.formBuilder.group({
      id: [],
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


  getAll() {
    this.httpClientAnamneseService.getAllAnamnese().subscribe({
      next: (dados) => {
        this.listaAnamnese = dados
      }
    })
  }

  onSubmit() {
    if (!this.id) {
      console.log('CAIU NO CREATE')
      this.saveAnamnese();
    } else {
      console.log('CAIU NO UPDATE')
      this.updateAnamnese(this.id, this.formAnamnese.value)
    }
  }

  saveAnamnese() {
    this.httpClientAnamneseService.saveAnamnese(this.formAnamnese.value)
      .subscribe({
        next: (dados) => {
          window.location.reload();
        }
      })
  }

  updateAnamnese(id: number, dadosAnamnese: iAnamneseModel) {
    this.httpClientAnamneseService.updateAnamnese(id, dadosAnamnese)
      .subscribe({
        next: (dados) => {
          window.location.reload();
        }
      })
  }

  abrirModalCreate(dadosAnamnese: iAnamneseModel) {
    document.getElementById('buttonOpenModal')?.click()
    this.id = dadosAnamnese.id
    this.formAnamnese.patchValue(dadosAnamnese)
  }

  deleteAnamnese(id: number) {
    this.httpClientAnamneseService.deleteAnamnese(id).subscribe({
      next: () => {

        this._snackBar.open('ITEM APAGADO COM SUCESSO', '', { duration: 3000 })
        this.getAll();

      }
    })
  }
}
