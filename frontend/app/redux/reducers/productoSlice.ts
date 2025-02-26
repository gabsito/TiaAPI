import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { Producto } from "@/app/interfaces/producto";

interface ProductoState {
  productos: Producto[];
}

const initialState: ProductoState = {
    productos: [],
};

export const productoSlice = createSlice({
  name: "productos",
  initialState,
  reducers: {
    agregarCurso: (state, action: PayloadAction<Producto>) => {
      state.productos.push(action.payload);
    },
    eliminarCurso: (state, action: PayloadAction<string>) => {
      state.productos = state.productos.filter(productos => productos.id !== action.payload);
    },
  },
});

export const { agregarCurso, eliminarCurso } = productoSlice.actions;
export default productoSlice.reducer;
