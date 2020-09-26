package modelo;

public class Medico {
	private String nombre;
	private String apellido;
	private String especialidad;
	private Paciente[] pacientesFrecuentes;

	public Medico(String nombre, String apellido, String especialidad, Paciente[] pacientesFrecuentes) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
		this.pacientesFrecuentes = pacientesFrecuentes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Paciente[] getPacientesFrecuentes() {
		return pacientesFrecuentes;
	}

	public void setPacientesFrecuentes(Paciente[] pacientesFrecuentes) {
		this.pacientesFrecuentes = pacientesFrecuentes;
	}

	public float calcularIMC(Paciente paciente) {
		float IMC;
		IMC = paciente.getPeso() / (paciente.getEstatura() * paciente.getEstatura());
		return IMC;
	}

	public double traerPromedioPeso() {
		double promedio = 0;
		double suma = 0;
		for (int i = 0; i < pacientesFrecuentes.length; i++) {
			suma = suma + pacientesFrecuentes[i].getPeso();
		}
		promedio = suma / pacientesFrecuentes.length;
		return promedio;
	}

	public Paciente traerPacienteMayorEstatura() {
		Paciente mayor = pacientesFrecuentes[0];
		for (int i = 0; i < pacientesFrecuentes.length; i++) {
			if (pacientesFrecuentes[i].getEstatura() > mayor.getEstatura()) {
				mayor = pacientesFrecuentes[i];
			}
		}
		return mayor;
	}

	public Paciente traerMenorIMC() {
		Paciente menor = pacientesFrecuentes[0];
		for (int i = 0; i < pacientesFrecuentes.length; i++) {
			if (calcularIMC(pacientesFrecuentes[i]) < calcularIMC(menor)) {
				menor = pacientesFrecuentes[i];
			}
		}
		return menor;
	}
}
