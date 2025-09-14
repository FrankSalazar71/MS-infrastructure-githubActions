package pe.edu.vallegrande.ms_infraestructura.domain.models;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.vallegrande.ms_infraestructura.domain.enums.BoxType;
import pe.edu.vallegrande.ms_infraestructura.domain.enums.Status;
import java.time.LocalDate;
import java.time.LocalDateTime;

class WaterBoxTest {
    @ParameterizedTest
    @CsvSource({
        "1,ORG1,BOX001,CAÑO,2023-01-01,10,ACTIVE",
        "2,ORG2,BOX002,BOMBA,2024-05-10,20,INACTIVE"
    })
    void testWaterBoxCreation(Long id, String organizationId, String boxCode, String boxType,
                              String installationDate, Long currentAssignmentId, String status) {
        WaterBox box = new WaterBox(
            id,
            organizationId,
            boxCode,
            BoxType.valueOf(boxType),
            LocalDate.parse(installationDate),
            currentAssignmentId,
            Status.valueOf(status),
            LocalDateTime.now()
        );
        assertEquals(id, box.getId());
        assertEquals(organizationId, box.getOrganizationId());
        assertEquals(boxCode, box.getBoxCode());
        assertEquals(BoxType.valueOf(boxType), box.getBoxType());
        assertEquals(LocalDate.parse(installationDate), box.getInstallationDate());
        assertEquals(currentAssignmentId, box.getCurrentAssignmentId());
        assertEquals(Status.valueOf(status), box.getStatus());
    }
}
