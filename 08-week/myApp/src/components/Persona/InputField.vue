<template>
  <div class="form-group">
    <label :for="id">{{ label }}</label>
    <input :id="id" v-model="modelValue" :type="type" class="form-control" required />
  </div>
</template>

<script>
export default {
  props: {
    label: String,
    id: String,
    type: String,
    modelValue: String
  },
  emits: ["update:modelValue"]
};
</script>