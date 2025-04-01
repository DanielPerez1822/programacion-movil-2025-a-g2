<template>
  <form @submit.prevent="submitForm">
    <div v-for="(value, key) in persona" :key="key" class="form-group">
      <label :for="key">{{ formatLabel(key) }}</label>
      <input
        :id="key"
        v-model="persona[key]"
        :type="inputType(key)"
        required
      />
    </div>
    <button type="submit">Guardar</button>
  </form>
</template>

<script>
export default {
  props: {
    initialData: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      persona: { ...this.initialData },
    };
  },
  methods: {
    submitForm() {
      this.$emit("guardar", this.persona);
    },
    inputType(field) {
      return field === "fechaNacimiento" ? "date" : field === "correo" ? "email" : "text";
    },
    formatLabel(label) {
      return label.charAt(0).toUpperCase() + label.slice(1);
    },
  },
};
</script>

<style scoped>
.form-group {
  margin-bottom: 1rem;
}
label {
  display: block;
  margin-bottom: 0.5rem;
}
input {
  width: 100%;
  padding: 0.5rem;
  font-size: 1rem;
  border: 1px solid #ccc;
  border-radius: 4px;
}
button {
  padding: 0.5rem 1rem;
  font-size: 1rem;
  color: #fff;
  background-color: #007bff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
button:hover {
  background-color: #0056b3;
}
</style>