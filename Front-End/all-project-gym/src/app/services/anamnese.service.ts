import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { environment } from 'src/environments/environment.development';
import { iAnamneseModel } from '../components/anamnese/iAnamneseModel';

@Injectable({
  providedIn: 'root'
})
export class AnamneseService {

  private apiUrl = `${environment.ApiUrl}/anamnese`

  constructor( private http: HttpClient ) { }

  getAllAnamnese(): Observable<iAnamneseModel[]> {
    return this.http.get<iAnamneseModel[]>(`${this.apiUrl}`)
    //.pipe(tap((anamnese) => { console.log("RETORNO", anamnese)}))
  }

  saveAnamnese(dadosAnamnese: iAnamneseModel){
    return this.http.post<iAnamneseModel>(`${this.apiUrl}`, dadosAnamnese)
  }
}

