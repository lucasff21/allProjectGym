import { iExercicioModel } from "src/app/util/iExercicioModel";

export class iAlunoModel {

  id!: number
  nome!: string;
  idade!: string;

  exercicios!: iExercicioModel[];

}
