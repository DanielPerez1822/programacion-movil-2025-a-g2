<template>
  <form @submit.prevent="submitForm">
    <InputField 
      v-for="(value, key) in persona" 
      :key="key" 
      :label="formatLabel(key)" 
      :id="key" 
      v-model="persona[key]"
      :type="inputType(key)"
    />
    <ButtonSubmit label="Guardar" />
  </form>
</template>

<script>
import InputField from "./InputField.vue";
import ButtonSubmit from "./ButtonSubmit.vue";


export default {
  components: { InputField, ButtonSubmit },
  props: {
    tipoUsuario: {
      type: String,
      required: true
    }
  },
  data() {
    return {
      persona: {
        nombre: "",
        apellido: "",
        documento: "",
        fechaNacimiento: "",
        direccion: "",
        telefono: "",
        correo: ""
      }
    };
  },
  methods: {
    submitForm() {
      this.$emit("guardar", { tipoUsuario: this.tipoUsuario, ...this.persona });
    },
    inputType(field) {
      return field === "fechaNacimiento" ? "date" : field === "correo" ? "email" : "text";
    },
    formatLabel(label) {
      return label.charAt(0).toUpperCase() + label.slice(1);
    }
  }
};
</script>