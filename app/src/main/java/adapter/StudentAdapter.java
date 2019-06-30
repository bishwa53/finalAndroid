package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asmntclass.R;

import java.util.List;

import model.Teacher;
import model.student;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {

    private List<student> studentList;
    private Context context;

    public StudentAdapter(List<student> studentList, Context context){
        this.studentList= studentList;
        this.context = context;
    }


    @NonNull
    @Override
    public StudentAdapter.StudentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.student_content, viewGroup,false);
        return new StudentAdapter.StudentHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentHolder studentHolder, int i) {

        final student student= studentList.get(i);

//        setting values in recyclerView
        studentHolder.tvFirstNameStudent.setText(student.getFirstName());
        studentHolder.tvLastNameStudent.setText(student.getLastName());
        studentHolder.spnClassStudent.setText(student.getClasses());
        studentHolder.tvContactStudent.setText(student.getContactNumber());
        studentHolder.tvAddressStudent.setText(student.getAddress());
        studentHolder.tvUsernameStudent.setText(student.getUsername());
        studentHolder.tvPasswordStudent.setText(student.getPassword());

    }


    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentHolder extends RecyclerView.ViewHolder
    {
        private TextView tvFirstNameStudent,tvLastNameStudent,spnClassStudent,tvContactStudent,tvAddressStudent,
                tvUsernameStudent,tvPasswordStudent;

        public StudentHolder(View itemView) {
            super(itemView);
            tvFirstNameStudent= itemView.findViewById(R.id.tvFirstNameStudent);
            tvLastNameStudent= (TextView) itemView.findViewById(R.id.tvLastNameStudent);
            spnClassStudent = itemView.findViewById(R.id.spnClass);
            tvContactStudent = itemView.findViewById(R.id.tvContactStudent);
            tvAddressStudent = itemView.findViewById(R.id.tvAddressStudent);
            tvUsernameStudent = itemView.findViewById(R.id.tvUsernameStudent);
            tvPasswordStudent = itemView.findViewById(R.id.tvPasswordStudent);
        }
    }
}
