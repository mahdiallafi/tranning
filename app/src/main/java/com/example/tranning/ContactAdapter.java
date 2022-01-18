package com.example.tranning;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{

    List<Contact> contacts;
    Context context;
    public ContactAdapter( Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.contact_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
        final Contact contsctAdapterList = contacts.get(position);
        holder.name.setText(contsctAdapterList.getName());
        //if i want to add image we can use glide labriary first we should add the gradle
       //// Glide.with(context).asBitmap().load(contacts.get(position).getImage()).into(holder.image);
        //add ClickEven
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create dialogue
                //Uncomment the below code to Set the message and title from the strings.xml file
                //  builder.setMessage("DO you want to delete your account?") .setTitle("Delete account");

                //Setting message manually and performing action on button click
                AlertDialog.Builder builder= new AlertDialog.Builder(context);
                builder.setMessage("Name: "+contsctAdapterList.getName()+"\n"+"Phone number"+String.valueOf(contsctAdapterList.getNumber()))
                        .setCancelable(false)
                        .setPositiveButton("make call", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent call=new Intent(Intent.ACTION_CALL);
                                call.setData(Uri.parse("tel:"+"123"));
                                context.startActivity(call);




                            }
                        })
                        .setNegativeButton("Cancel ", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();

                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Contact info");
                alert.show();

            }
        });
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

      TextView name;
      ConstraintLayout parent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            parent=itemView.findViewById(R.id.parent);

        }
    }
}
