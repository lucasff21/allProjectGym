import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import { iAlunoModel } from '../components/aluno/iAlunoModel';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlunoService {

  private apiUrl = `${environment.ApiUrl}/aluno`

  constructor( private http: HttpClient ) { }

  saveAluno(aluno: iAlunoModel): Observable<iAlunoModel> {
    return this.http.post<iAlunoModel>(`${this.apiUrl}`, aluno);
  }

  getAllAluno(): Observable<iAlunoModel[]> {
    return this.http.get<iAlunoModel[]>(`${this.apiUrl}`);
  }

  getAlunoId(id: number): Observable<iAlunoModel> {
    return this.http.get<iAlunoModel>(`${this.apiUrl}/${id}`)
  }

  updateAluno(id: number, aluno: iAlunoModel): Observable<iAlunoModel> {
    return this.http.put<iAlunoModel>(`${this.apiUrl}/${id}`, aluno)
  }

  deleteAluno(id: number){
    return this.http.delete(`${this.apiUrl}/${id}`)
  }
}
