import { iAlunoModel } from "../components/aluno/iAlunoModel";

export interface iExercicioModel {
  id?: number;
  grupo_muscular: string;
  series: number;
  repeticoes: number;
  peso: number;
  observacao: string;
  data: Date;
  alunos: iAlunoModel[];
}
