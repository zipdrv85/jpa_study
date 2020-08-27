import java.util.List;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.inzent.selenium.entity.Child;
import com.inzent.selenium.entity.Parent;
import com.inzent.selenium.repository.ParentRepository;


@Component
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OneToManyRunner implements CommandLineRunner {

    @NonNull
    private ParentRepository parentRepository;

    @Override
    public void run(String... args) throws Exception {
        Parent parent1 = new Parent("parent 1");
        for (int i = 1 ; i <= 10 ; i++) {
            parent1.getChildren().add(
                    new Child("child " + i)
            );
        }

        Parent dbParent = this.parentRepository.saveAndFlush(parent1);

        System.out.println("*****************************");
        
        List<Child> children = dbParent.getChildren();
        children.removeIf(child -> 
                child.getId() == 1L || child.getId() == 2L);
    }
}
