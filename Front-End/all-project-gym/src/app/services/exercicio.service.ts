import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';
import { iExercicioModel } from '../util/iExercicioModel';

@Injectable({
  providedIn: 'root'
})
export class ExercicioService {

  private apiUrl = `${environment.ApiUrl}/exercicio`

  constructor( private http: HttpClient ) { }

  getAllAnamnese(): Observable<iExercicioModel[]> {
    return this.http.get<iExercicioModel[]>(`${this.apiUrl}`)
  }
}
