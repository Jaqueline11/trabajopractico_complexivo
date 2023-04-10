package com.example.DisfracesFront.controller;


import com.example.DisfracesFront.models.AlquilerDisfraz;
import com.example.DisfracesFront.models.Cliente;
import com.example.DisfracesFront.models.Disfraces;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {
    List<Cliente> clientes=new ArrayList<>();
    @GetMapping({"/index","/", "/home"})
    public String index(Model model){
        model.addAttribute("titulo","Bienvenido");
        return "HOME";
    }

    @Value("${texto.indexcontroller.textop.titulo}")
    private String textop;


    @GetMapping("/mix-params")
    public String param(@RequestParam String nombre,@RequestParam String fecha, Model model){

        model.addAttribute("resultado","El cliente: "+nombre+" tiene que devolver el aquiler el: "+fecha);
        model.addAttribute("titulo","Fecha de entrega");
        return "mensaje";
    }
    @GetMapping("/string")
    public String param(@RequestParam (name="texto", required = false,defaultValue = "cualquier valor") String texto, Model model){

        model.addAttribute("resultado","El comentario es: "+ texto);
        model.addAttribute("titulo","Comentario detallado");

        return "mensaje";
    }

    @RequestMapping("/clientes")
    public String clientes(Model model){
        Cliente cliente= new Cliente();
        cliente.setId_cliente(1l);
        cliente.setCedula("0605444793");
        cliente.setNombres_cliente("Myrian");
        cliente.setApellidos_cliente("Cutiopala");
        cliente.setDireccion_cliente("Feria Libre");
        cliente.setEstado_cliente(false);
        model.addAttribute("cliente",cliente);

        /*/*/

        clientes.add(cliente);
        Cliente c = new Cliente(2L,"0123456789","Jaqui", "Cutiopala", "Miraflores", false);
        clientes.add(c);
        Cliente c1 = new Cliente(3L,"0123456789","Maribel", "Cutiopala", "Miraflores", false);
        clientes.add(c1);

        model.addAttribute("clientes",clientes);
        return "index";
    }

    @GetMapping("/ver/{id}")
    public String verCliente(@PathVariable("id") int id, Model model) {
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getId_cliente() == id) {
                cliente = c;
                break;
            }
        }
        if (cliente == null) {
            return "error";
        }
        model.addAttribute("cliente", cliente);
        model.addAttribute("titulo", textop.concat(cliente.getNombres_cliente()));
        return "params/ver";
    }
    @GetMapping("/guardarClient")
    public String editarCliente(@RequestParam Long id, Model model) {
        Cliente cliente = clientes.stream().filter(c -> c.getId_cliente().equals(id)).findFirst().orElse(null);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "cliente";
        } else {
            return "redirect:/app/clientes";
        }
    }
    @PostMapping("/guardarCliente")
    public String guardarCliente(@Valid Cliente cliente, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "cliente";
        }
        Cliente clienteEditado = clientes.stream().filter(c -> c.getCedula().equals(cliente.getCedula())).findFirst().orElse(null);
        if (clienteEditado != null) {
            // Actualizar los datos del cliente
            clienteEditado.setNombres_cliente(cliente.getNombres_cliente());
            clienteEditado.setApellidos_cliente(cliente.getApellidos_cliente());
            clienteEditado.setDireccion_cliente(cliente.getDireccion_cliente());
        }
        int id=clientes.size()+1;
        long idl=(long) id;
        cliente.setId_cliente(idl);
        clientes.add(cliente);
        model.addAttribute("cliente", clientes);
        return "redirect:/app/clientes";
    }


    @RequestMapping("/listar")
    public String listar(Model model){
        List<Disfraces> disfraz=new ArrayList<>();
        Disfraces c = new Disfraces(1L,"1","Vestido negro",10.0,"teatrales");
        disfraz.add(c);
        model.addAttribute("titulo","Listado de disfraces");
        model.addAttribute("disfraz",disfraz);
        return "listadisfraz";
    }

    @RequestMapping("/listaralquiler")
    public String listaralquiler(Model model){
        List<AlquilerDisfraz> alquiler=new ArrayList<>();
        Cliente ce = new Cliente(2L,"0123456789","Jaqui", "Cutiopala", "Miraflores", false);
        Disfraces c = new Disfraces(1L,"1","Vestido negro",10.0,"teatrales");

        AlquilerDisfraz al = new AlquilerDisfraz(1l,ce,c,"04/05/2023","10/04/2023","cedula",10.0,10.0);
        alquiler.add(al);
        model.addAttribute("alquiler",alquiler);
        return "listaalquiler";
    }




}
