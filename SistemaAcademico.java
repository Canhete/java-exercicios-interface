import java.util.ArrayList;
import java.util.List;

public class SistemaAcademico {
    public static abstract class Pessoa {
        protected String nome;

        // Constructor
        public Pessoa(String nome) {
            this.nome = nome;
        }

        // Método sobreescrito
        @Override
        public abstract String toString();
    }

    public static class Professor extends Pessoa {
        private double salario;
        private List<Disciplina> disciplinas;

        // Constructor
        public Professor(String nome, double salario) {
            super(nome);
            this.salario = salario;
            disciplinas = new ArrayList<>();
        }

        // Método sobrescrito
        @Override
        public String toString() {
            return "Professor{" + "nome='" + nome + '\'' + ", salario=" + salario + '}';
        }

        // Getters
        public List<Disciplina> getDisciplinas() {
            return disciplinas;
        }
    }

    public static class Aluno extends Pessoa {
        private List<Disciplina> matricula;

        // Constructor
        public Aluno(String nome) {
            super(nome);
            matricula = new ArrayList<>();
        }

        // Método sobrescrito
        @Override
        public String toString() {
            return "Aluno{" + "nome='" + nome + '\'' + '}';
        }
    }

    public static class Disciplina {
        private String nome;
        private Professor professor;
        private List<Aluno> matriculados;

        // Constructor
        public Disciplina(String nome, Professor professor) {
            this.nome = nome;
            definirProfessor(professor);
            matriculados = new ArrayList<>();
        }

        // Métodos
        public void matricularAluno(Aluno a) {
            if (a.nome == null || a.nome.isEmpty()) {
                throw new IllegalArgumentException("Aluno não deve ser nulo. Aluno: " + a.toString());
            }

            matriculados.add(a);
            a.matricula.add(this);
        }

        public void definirProfessor(Professor p) {
            if (p == null) {
                throw new IllegalArgumentException("Professor não deve ser nulo. Professor: " + p.toString());
            }

            professor = p;
            p.disciplinas.add(this);
        }

        public void info() {
            System.out.println("Disiciplina: " + nome);
        }

        // Método sobrescrito
        @Override
        public java.lang.String toString() {
            return "Disciplina{" +
                    "nome='" + nome + '\'' +
                    ", professor=" + professor +
                    ", matriculados=" + matriculados +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Professor> professores = new ArrayList<>(List.of(
                new Professor("Pedro", 1500.00),
                new Professor("Ana", 1680.00),
                new Professor("Carlinhos", 1789.50)
        ));

        List<Disciplina> disciplinas = new ArrayList<>(List.of(
                new Disciplina("Matemática", professores.get(0)),
                new Disciplina("Ciências", professores.get(1)),
                new Disciplina("Filosofia", professores.get(2))
        ));

        List<Aluno> alunos = new ArrayList<>(List.of(
                new Aluno("Alberto"),
                new Aluno("Bianca"),
                new Aluno("Camila"),
                new Aluno("Denise"),
                new Aluno("Edigar"),
                new Aluno("Frederico")
        ));

        disciplinas.get(0).matricularAluno(alunos.get(0));
        disciplinas.get(0).matricularAluno(alunos.get(1));
        disciplinas.get(0).matricularAluno(alunos.get(2));
        disciplinas.get(1).matricularAluno(alunos.get(3));
        disciplinas.get(1).matricularAluno(alunos.get(4));
        disciplinas.get(1).matricularAluno(alunos.get(5));
        disciplinas.get(2).matricularAluno(alunos.get(2));
        disciplinas.get(2).matricularAluno(alunos.get(3));
        disciplinas.get(2).matricularAluno(alunos.get(4));

        for (Disciplina d : disciplinas) {
            System.out.println(d.toString());
        }

        for (Professor p : professores) {
            System.out.println(p.toString());
        }

        for (Aluno a : alunos) {
            System.out.println(a.toString());
        }
    }
}