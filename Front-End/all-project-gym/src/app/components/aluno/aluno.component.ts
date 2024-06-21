import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AlunoService } from 'src/app/services/aluno.service';
import { iAlunoModel } from './iAlunoModel';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { AlunoModalComponent } from './alunoFormModal/aluno-modal.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-aluno',
  templateUrl: './aluno.component.html',
  styleUrls: ['./aluno.component.scss']
})
export class AlunoComponent implements OnInit {
  modalOpen = false;

  formAluno!: FormGroup;

  constructor(
    private httpClientAlunoService: AlunoService,
    private formBuilder: FormBuilder,
    private _snackBar: MatSnackBar,
    public dialog: MatDialog
  ) {
    this.formAluno = this.formBuilder.group({
      id: [],
      nome: ['', [Validators.required]],
      idade: ['', [Validators.required]],
      exercicios: [[], [Validators.required]],
    })
  }

  ngOnInit() {
    this.getAllAluno();
  }

  displayedColumns = ['nome', 'idade', 'ações']; // Defina suas colunas aqui

  // Inicialize a fonte de dados da tabela com MatTableDataSource
  alunosList = new MatTableDataSource<iAlunoModel>();

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  ngAfterViewInit() {
    // Vincule o paginator e o sort à fonte de dados
    this.alunosList.sort = this.sort;
    this.alunosList.paginator = this.paginator;
  }

  getAllAluno() {
    this.httpClientAlunoService.getAllAluno().subscribe({
      next: (alunos) => {
        console.log(alunos);
        // Atribua os dados recebidos à fonte de dados da tabela
        this.alunosList.data = alunos;
      }
    });
  }

  openModal(aluno?: iAlunoModel) {
    const dialogRef = this.dialog.open(AlunoModalComponent, {
      width: '40%',
      disableClose: true,
      data: {aluno} // quando for atualizar o aluno
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
      if (result !== undefined) {
        console.log('Dados recebidos do modal:', result);
        this.httpClientAlunoService.saveAluno(result).subscribe({
          next: () => {
            this.getAllAluno();
            this._snackBar.open('Usuario cadastro', '', { duration: 4000 });
          }, error: (e) => {
            console.log(e)
          }
        })

      } else {
        console.log('Operação cancelada pelo usuário.');
      }
    });
  }

  deleteAluno(id: number){
    this.httpClientAlunoService.deleteAluno(id).subscribe({
      next: () => {
        this.getAllAluno();
        this._snackBar.open('Usuario deleteado', '', { duration: 4000 });
      }, error: (e) => {
        console.log(e)
      }
    })
  }
}
